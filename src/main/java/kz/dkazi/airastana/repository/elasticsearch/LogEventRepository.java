package kz.dkazi.airastana.repository.elasticsearch;

import kz.dkazi.airastana.entity.elasticsearch.LogEventDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LogEventRepository extends ElasticsearchRepository<LogEventDoc, String> {
}
