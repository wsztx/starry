package com.universe.starry.system.config;

import com.universe.starry.common.constant.BaseConstant;
import com.universe.starry.common.util.IPAndMacUtil;
import com.universe.starry.system.entity.Log;
import com.universe.starry.system.mapper.LogMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogMapper logMapper;

    private static final int MAX_LENGTH = (64 * 1024) / 3;

    @Pointcut("execution(public * com.universe.starry.*.controller..*.*(..))")
    public void controllerLog(){}

    @Before("controllerLog()")
    public void logBeforeController(JoinPoint joinPoint) {

    }

    @Around("controllerLog()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Log data = new Log();
        // 设置操作开始时间
        LocalDateTime startTime = LocalDateTime.now();
        Long startTimeLong = startTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        data.setOperateTime(startTime);

        data.setStatus(BaseConstant.UNDELETE_STATUS);
        // 设置IP和MAC地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            data.setOperateIp(IPAndMacUtil.getIP(request));
            //log.setOperateMac(IPAndMacUtil.getMACAddress(log.getOperateIp()));
        } catch (Exception e) {
            log.error("Get IP or MAC error.", e);
        }
//        // 如果已经登录,设置操作人id
//        CustomSession customSession = (CustomSession)SecurityUtils.getSubject().getPrincipal();
//        if(customSession != null){
//            data.setOperateUserId(customSession.getUserId());
//        }
        data.setModelType(point.getTarget().getClass().getName());
        data.setOperateType(point.getSignature().getName());

        // 设置操作对象(传入参数)
        Object[] params = point.getArgs();
        String paramsStr = StringUtils.join(params, ",");
        if(paramsStr.length() > MAX_LENGTH){
            data.setOperateObject(paramsStr.substring(0, MAX_LENGTH));
        }else{
            data.setOperateObject(paramsStr);
        }

        Object object;
        try {
            object = point.proceed();
        } catch (Exception exception) {
            String exceptStr = exception.getMessage();
            // 设置操作结果
            if(exceptStr.length() > MAX_LENGTH){
                data.setOperateResult(exceptStr.substring(0, MAX_LENGTH));
            }else{
                data.setOperateResult(exceptStr);
            }
//            // 如果操作前未登录,操作后再次设置操作人id
//            if(data.getOperateUserId() == null){
//                customSession = (CustomSession)SecurityUtils.getSubject().getPrincipal();
//                if(customSession != null){
//                    data.setOperateUserId(customSession.getUserId());
//                }
//            }
            // 设置操作持续时间
            Long endTimeLong = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
            data.setTimeSpan(endTimeLong.intValue() - startTimeLong.intValue());
            logMapper.insert(data);
            throw exception;
        }
        // 设置操作结果(方法返回结果)
        String objStr = object == null ? "" : object.toString();
        if(objStr.length() > MAX_LENGTH){
            data.setOperateResult(objStr.substring(0, MAX_LENGTH));
        }else{
            data.setOperateResult(objStr);
        }
//        // 如果操作前未登录,操作后再次设置操作人id
//        if(data.getOperateUserId() == null){
//            customSession = (CustomSession)SecurityUtils.getSubject().getPrincipal();
//            if(customSession != null){
//                data.setOperateUserId(customSession.getUserId());
//            }
//        }
        // 设置操作持续时间
        Long endTimeLong = new Date().getTime();
        data.setTimeSpan(endTimeLong.intValue() - startTimeLong.intValue());
        logMapper.insert(data);
        return object;
    }
}
