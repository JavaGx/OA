package cn.gx.oa.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gx.oa.base.BaseDaoImpl;
import cn.gx.oa.domain.FormTemplate;
import cn.gx.oa.service.FormTemplateService;

@Service
@Transactional
public class FormTemplateServiceImpl extends BaseDaoImpl<FormTemplate>
		implements FormTemplateService {

}
