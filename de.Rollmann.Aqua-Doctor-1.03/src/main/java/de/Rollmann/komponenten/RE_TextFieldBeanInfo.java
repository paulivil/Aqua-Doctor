package de.Rollmann.komponenten;

import java.awt.Image;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class RE_TextFieldBeanInfo
  extends SimpleBeanInfo
{
  Class<RE_TextField> beanClass = RE_TextField.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;
  
  public PropertyDescriptor[] getPropertyDescriptors()
  {
    try
    {
      PropertyDescriptor _enabled = new PropertyDescriptor(
        "enabled", beanClass, "isEnabled", "setEnabled");
      
      PropertyDescriptor _maxCount = new PropertyDescriptor(
        "maxCount", beanClass, "getMaxCount", "setMaxCount");
      
      return new PropertyDescriptor[] {
        _enabled, 
        _maxCount };
    }
    catch (Exception ex) {}
    return null;
  }
  
  public Image getIcon(int iconKind)
  {
    switch (iconKind)
    {
    case ICON_COLOR_16x16: 
      return iconColor16x16Filename != null ? 
        loadImage(iconColor16x16Filename) : null;
    case ICON_COLOR_32x32: 
      return iconColor32x32Filename != null ? 
        loadImage(iconColor32x32Filename) : null;
    case ICON_MONO_16x16: 
      return iconMono16x16Filename != null ? 
        loadImage(iconMono16x16Filename) : null;
    case ICON_MONO_32x32: 
      return iconMono32x32Filename != null ? 
        loadImage(iconMono32x32Filename) : null;
    }
    return null;
  }
  
  public BeanInfo[] getAdditionalBeanInfo()
  {
    Class<?> superclass = beanClass.getSuperclass();
    try
    {
      BeanInfo superBeanInfo = Introspector.getBeanInfo(superclass);
      return new BeanInfo[] { superBeanInfo };
    }
    catch (IntrospectionException e) {}
    return null;
  }
}

