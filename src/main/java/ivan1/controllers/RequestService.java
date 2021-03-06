package ivan1.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestService extends BaseService {
}
