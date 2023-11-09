package kz.dkazi.airastana.logging;

import kz.dkazi.airastana.enums.EventSection;
import kz.dkazi.airastana.enums.EventType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogEvent {

    /**
     * Тип события
     *
     * @return
     */
    EventType type() default EventType.UNDEFINED;

    /**
     * Шаблон описания события.<br>Если в шаблоне написать %s,
     * то вместо %s через запятую будут указаны наименования параметров, где значение != null<br><br>
     * Пример:<br><br>
     * {@literal @}LogEvent(<br>
     * template = "Вызов метода с параметрами %s",<br>
     * values = true<br>)<br>
     * someMethod(Long id, String name)<br><br>
     * Создаст событие с описанием "Вызов метода с параметрами id, name"
     * @return
     */
    String template() default "Нет описания";

    /**
     * Включать значения параметров в описание события.<br>
     * Пример:<br><br>
     * {@literal @}LogEvent(<br>
     * template = "Чтение записи %s",<br>
     * values = true<br>)<br>
     * someMethod(Long id)<br><br>
     * Создаст событие с описанием "Чтение записи id=123"
     * @return
     */
    boolean values() default false;
}
