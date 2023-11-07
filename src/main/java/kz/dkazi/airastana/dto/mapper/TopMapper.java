package kz.dkazi.airastana.dto.mapper;

public interface TopMapper<T, D> {

    T toEntity(D dto);

    D toDto(T entity);

}
