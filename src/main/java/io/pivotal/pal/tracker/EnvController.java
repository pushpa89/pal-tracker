package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    private String port;
    private String memory_limit;
    private String cf_instance_index;
    private String cf_instance_addr;

    public EnvController(@Value("${port:127.0.0.1}") String pport,
                         @Value("${memory.limit:512MB}") String pmemory_limit,
                         @Value("${cf.instance.index:instance1}") String pcf_instance_index,
                         @Value("${cf.instance.addr:address1}")  String pcf_instance_addr)
    {
        this.port = pport;
        this.memory_limit = pmemory_limit;
        this.cf_instance_index = pcf_instance_index;
        this.cf_instance_addr = pcf_instance_addr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv()
    {
        Map<String, String> hmEnv = new HashMap<String, String>();

        hmEnv.put("PORT", this.port);
        hmEnv.put("MEMORY_LIMIT", this.memory_limit);
        hmEnv.put("CF_INSTANCE_INDEX", this.cf_instance_index);
        hmEnv.put("CF_INSTANCE_ADDR", this.cf_instance_addr);

        return hmEnv;
    }

}