package hasanalmunawarDev.SpringBasic.aLatihan.facto;

import hasanalmunawarDev.SpringBasic.aLatihan.entity.Major;
import org.springframework.beans.factory.FactoryBean;

public class MajorFactoryBean implements FactoryBean<Major> {
    @Override
    public Major getObject() throws Exception {
        Major major = new Major();
        major.setId("9913");
        major.setName("Informatic engginering");
        major.setAddres("Singkut");
        return major;
    }

    @Override
    public Class<?> getObjectType() {
        return Major.class;
    }
}
