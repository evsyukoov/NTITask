package com.task;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wordanalyzer/analyze")
public class ApiController {

    @GetMapping
    public Object API(@RequestParam("word") String param) {
        WordAnalizer analizer = new WordAnalizer(param);
        analizer.findSymbol();
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("letter", analizer.getResult().getKey().toString());
        node.put("count", analizer.getResult().getValue());
        return node;
    }

}
