package hasanalmunawrDev.webMvc.resolver;

import hasanalmunawrDev.webMvc.model.Partner;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class PartnerArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Partner.class);
    }

//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        HttpServletRequest servletRequest = (HttpServletRequest) webRequest.getNativeRequest();
//        String apiKey = servletRequest.getHeader("X-API-KEY");
//
//        if (apiKey != null) {
//            // query ke database
//            return new Partner(apiKey, "Sample Partner");
//        }
//
//        throw new RuntimeException("Unauthorized Exception");
//    }
//
//    @Override
//    public boolean supportsParameter(MethodParameter parameter) {
//        return  parameter.getParameterType().equals(Partner.class);
//    }
//
    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String apiKey = request.getHeader("X-API-KEY");
        if (apiKey != null) {
            // query to database
            return new Partner(apiKey, "Sample partner");
        }
        return new RuntimeException("Unauthorized Exception");

    }
}
