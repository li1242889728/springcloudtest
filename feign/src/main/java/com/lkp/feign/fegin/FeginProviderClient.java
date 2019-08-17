package com.lkp.feign.fegin;

import com.lkp.feign.entity.Student;
import com.lkp.feign.fegin.impl.FeginError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

//fallback服务容错做降级处理
@FeignClient(value = "provider",fallback = FeginError.class)
public interface FeginProviderClient {

    @GetMapping("student/findAll")
    public Collection<Student> findAll();

    @GetMapping("student/index")
    public String index();
}
