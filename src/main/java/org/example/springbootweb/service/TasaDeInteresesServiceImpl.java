package org.example.springbootweb.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.springbootweb.entity.TasaDeIntereses;
import org.example.springbootweb.repository.TasaDeInteresesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.cache.annotation.CacheDefaults;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

@CacheDefaults(cacheName = "tasa_de_intereses")
public class TasaDeInteresesServiceImpl implements TasaDeInteresesService {
    @Autowired
    TasaDeInteresesRepository tasaDeInteresesRepository;

    private static final Logger LOGGER = LogManager.getLogger(TasaDeInteresesServiceImpl.class.getName());

    public TasaDeIntereses getTasaDeInteres(Long id) {
        return tasaDeInteresesRepository.findById(id).get();
    }

    public TasaDeIntereses getTasaDeInteresByInteresCode(String interesCode) {
        return tasaDeInteresesRepository.findByInteresCode(interesCode);
    }


    public List<TasaDeIntereses> findAll() {
        return tasaDeInteresesRepository.findAll();
    }

    public Map<String, Object> getTasaDeInteresMap() {
        LOGGER.debug("Executing task");
        Map<String, Object> tasaDeInteresMap = new HashMap<String, Object>();
        for (TasaDeIntereses tasaDeIntereses : findAll()) {
            tasaDeInteresMap.put(tasaDeIntereses.getInteresCode(), tasaDeIntereses.getInteresMonto());
        }
        return tasaDeInteresMap;
    }
}
