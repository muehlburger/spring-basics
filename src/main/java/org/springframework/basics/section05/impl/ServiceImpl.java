package org.springframework.basics.section05.impl;

import org.springframework.basics.section05.Factory;
import org.springframework.basics.section05.IComponent;
import org.springframework.basics.section05.IService;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IService {
}
