package hasanalmunawarDev.SpringBasic.processor;

import hasanalmunawarDev.SpringBasic.aware.IdAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PrefixIdGeneratorBeanPostProcessor implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Prefix id generaotor by {}", beanName);
        if(bean instanceof IdAware) {
            IdAware idAware = (IdAware) bean;
            log.info("Prefix set id generator by {}", beanName);
            idAware.setId("HSN-"+ idAware.getId());
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
