package core.support.proxy.bs;

import api.ICache;
import annotation.CacheInterceptor;

import java.lang.reflect.Method;

/**
 * @author lujiaxin
 * @date 2023/5/8
 */
public interface ICacheProxyBsContext {

    /**
     * 拦截器信息
     * @return 拦截器
     * @since 0.0.5
     */
    CacheInterceptor interceptor();

    /**
     * 获取代理对象信息
     * @return 代理
     * @since 0.0.4
     */
    ICache target();

    /**
     * 目标对象
     * @param target 对象
     * @return 结果
     * @since 0.0.4
     */
    ICacheProxyBsContext target(final ICache target);

    /**
     * 参数信息
     * @return 参数信息
     * @since 0.0.4
     */
    Object[] params();

    /**
     * 方法信息
     * @return 方法信息
     * @since 0.0.4
     */
    Method method();

    /**
     * 方法执行
     * @return 执行
     * @since 0.0.4
     * @throws Throwable 异常信息
     */
    Object process() throws Throwable;

}
