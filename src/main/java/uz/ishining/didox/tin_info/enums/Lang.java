package uz.ishining.didox.tin_info.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Lang {

    RU("ru"),
    UZ("uz");

    private final String value;

    Lang(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Lang fromValue(String key){
        if(key != null){
            for(Lang type: values()){
                if(type.value.equals(key))
                    return type;
            }
        }
        return null;
    }

    @JsonValue
    public String toValue(){
        return value;
    }
}
