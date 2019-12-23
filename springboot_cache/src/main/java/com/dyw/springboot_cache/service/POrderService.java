package com.dyw.springboot_cache.service;

import com.dyw.springboot_cache.bean.POrder;
import com.dyw.springboot_cache.mapper.POrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class POrderService {
    private static final String ORDER_CACHE_NAME = "order";

    @Autowired(required = false)
    private POrderMapper POrderMapper;

    @CacheEvict(value = ORDER_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public POrder saveByOrder(POrder POrder) {
        if (POrder != null && POrder.getId() != null) {
            POrderMapper.updateById(POrder);
        } else {
            POrderMapper.insert(POrder);
        }
        return POrder;
    }

    @CacheEvict(value = ORDER_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void removeByOrderId(Integer id) {
        POrderMapper.deleteById(id);
    }

    @Cacheable(value = ORDER_CACHE_NAME, key = "'order_all'")
    public List<POrder> findAllOrders() {
        return POrderMapper.findAll();
    }

    @Cacheable(value = ORDER_CACHE_NAME, key = "'order_id_'+#id", unless = "#result == null")
    public POrder findByOrderId(Integer id) {
        return POrderMapper.selectById(id);
    }

    @Cacheable(value = ORDER_CACHE_NAME, key = "'orders_count'")
    public Integer getCount() {
        return POrderMapper.selectCount();
    }
}
