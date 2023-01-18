package com.tc.nb.service;

import com.tc.nb.service.exception.ServiceException;

public interface  DataCheckingService {
	boolean isContentNotNull(String content) throws ServiceException;
}
