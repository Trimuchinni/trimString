package com.github.Trimuchinni.TrimString;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import java.lang.reflect.Field;

@Component
public class TrimStringConfig implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        // TODO Auto-generated method stub
        return bean;
    }

    public Object postProcessAfterInitialization(Object object, String beanName) {
        // TODO Auto-generated method stub
//        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    	    try {
    	      Field[] fields = object.getClass().getDeclaredFields();
    	      for (Field field : fields) {
    	        if (field.isAnnotationPresent(TrimString.class) && field.getType() == String.class) {
    	          field.setAccessible(true);
    	          String value = (String) field.get(object);
    	          if (value != null) {
    	            String newValue = value.replaceAll("\\s", "");
    	            field.set(object, newValue);
    	          }
    	        }
    	      }
    	    } catch (IllegalAccessException e) {
    	      e.printStackTrace();
    	    }
    	    return object;
    }
}
