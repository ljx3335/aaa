/*
 * Copyright (c)  2019. houbinbin Inc.
 * async All rights reserved.
 */

package core.support.proxy;

import api.ICache;
import core.support.proxy.cglib.CglibProxy;
import core.support.proxy.dynamic.DynamicProxy;
import core.support.proxy.none.NoneProxy;
import com.github.houbb.heaven.util.lang.ObjectUtil;

import java.lang.reflect.Proxy;

/**
 * <p> 代理信息 </p>
 * @author lujiaxin
 * @date 2023/5/8
 */
public final class CacheProxy {

    private CacheProxy(){}

    /**
     * 获取对象代理
     * @param <K> 泛型 key
     * @param <V> 泛型 value
     * @param cache 对象代理
     * @return 代理信息
     * @since 0.0.4
     */
    @SuppressWarnings("all")
    public static <K,V> ICache<K,V> getProxy(final ICache<K,V> cache) {
        if(ObjectUtil.isNull(cache)) {
            return (ICache<K,V>) new NoneProxy(cache).proxy();
        }

        final Class clazz = cache.getClass();

        // 如果targetClass本身是个接口或者targetClass是JDK Proxy生成的,则使用JDK动态代理。
        // 参考 spring 的 AOP 判断
        if (clazz.isInterface() || Proxy.isProxyClass(clazz)) {
            return (ICache<K,V>) new DynamicProxy(cache).proxy();
        }

        return (ICache<K,V>) new CglibProxy(cache).proxy();
    }

}
