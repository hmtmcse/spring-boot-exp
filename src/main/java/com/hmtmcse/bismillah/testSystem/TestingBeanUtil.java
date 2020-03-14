package com.hmtmcse.bismillah.testSystem;

import com.hmtmcse.bismillah.domain.Course;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

public class TestingBeanUtil {

    public static void main(String[] args) {
        Course course = new Course().name("Bangla").credit(1.5);
        Course fromPost = new Course().description("This is bangla Description");
        BeanWrapper beanWrapper = new BeanWrapperImpl(course);

//        BeanUtils.copyProperties(fromPost, course);
        myCopyProperties(fromPost, course);
        System.out.println(course);
        System.out.println(fromPost);

//        manualCopy();
    }

    public static void copyNotNull(){

    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }


    public static void myCopyProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static void manualCopy(){
        BeanWrapper beanWrapper = new BeanWrapperImpl(new Course());
        beanWrapper.setPropertyValue("name", "Bangla");
        beanWrapper.setPropertyValue("credit", 1.5);
        Course fromPost = new Course().description("This is bangla Description");
        fromPost.setDescription("This is bangla Description");
        BeanUtils.copyProperties(beanWrapper.getWrappedInstance(), fromPost);
        System.out.println(fromPost);
    }




}
