package org.example.springbootweb.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.springbootweb.entity.Property;
import org.example.springbootweb.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.cache.annotation.CacheDefaults;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@CacheDefaults(cacheName = "property")
public class PropertyServiceImpl implements PropertyService{
    @Autowired
    PropertyRepository propertyRepository;

    private static final Logger LOGGER = LogManager.getLogger(PropertyServiceImpl.class.getName());

    public List<Property> findAll(){
        return propertyRepository.findAll();
    }
    public Map<String, Object> getPropertiesMap(){
        LOGGER.debug("Executing task");
        Map<String, Object> propertiesMap = new HashMap<String,Object>();
        for (Property property:findAll()) {
            propertiesMap.put(property.getPropertyCode(),property.getPropertyValue());
        }
        return propertiesMap;
    }
}
