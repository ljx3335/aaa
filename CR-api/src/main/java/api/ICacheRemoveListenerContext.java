package api;

/**
 * 删除监听器上下文
 *（1）耗时统计
 *（2）监听器
 * @author lujiaxin
 * @date 2023/5/8
 */
public interface ICacheRemoveListenerContext<K,V> {

    /**
     * 清空的 key
     * @return key
     * @since 0.0.6
     */
    K key();

    /**
     * 值
     * @return 值
     * @since 0.0.6
     */
    V value();

    /**
     * 删除类型
     * @return 类型
     * @since 0.0.6
     */
    String type();

}
