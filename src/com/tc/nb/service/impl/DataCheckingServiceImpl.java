package com.tc.nb.service.impl;

import com.tc.nb.service.DataCheckingService;
import com.tc.nb.service.exception.ServiceException;

public class DataCheckingServiceImpl implements DataCheckingService{

	@Override
	public boolean isContentNotNull(String content) throws ServiceException {
		if (content!="") {
			return true;
		}else {
			throw new ServiceException("Content is null");
		}
	}

}
