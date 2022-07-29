package cn.qkmango.tms.domain.orm;

import cn.qkmango.tms.common.validate.group.Delete;
import cn.qkmango.tms.common.validate.group.Insert;
import cn.qkmango.tms.common.validate.group.Update;
import cn.qkmango.tms.updateQuery.controller.UpdateSystemController;

import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

/**
 * @author qkmango
 * @version 1.0
 * @className SystemKeyValue
 * @Description 系统键值对类
 * @date 2022-07-28 19:20
 */
public class SystemKeyValue {
    @NotBlank(message = "{valid.SystemKeyValue.key.NotBlank}",
            groups = {Insert.InsertSystemKeyValue.class, Delete.DeleteSystemKeyValue.class,Update.UpdateSystemKeyValue.class})
    private String key;
    @NotBlank(message = "{valid.SystemKeyValue.value.NotBlank}", groups = {Insert.InsertSystemKeyValue.class})
    private String value;

    @NotBlank(message = "{valid.SystemKeyValue.newKey.NotBlank}", groups = {Update.UpdateSystemKeyValue.class,})
    private String newKey;
    @NotBlank(message = "{valid.SystemKeyValue.newValue.NotBlank}", groups = {Update.UpdateSystemKeyValue.class})
    private String newValue;

    public SystemKeyValue() {
    }

    public SystemKeyValue(String key, String value, String newKey, String newValue) {
        this.key = key;
        this.value = value;
        this.newKey = newKey;
        this.newValue = newValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNewKey() {
        return newKey;
    }

    public void setNewKey(String newKey) {
        this.newKey = newKey;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SystemKeyValue.class.getSimpleName() + "[", "]")
                .add("key='" + key + "'")
                .add("value='" + value + "'")
                .add("newKey='" + newKey + "'")
                .add("newValue='" + newValue + "'")
                .toString();
    }
}
