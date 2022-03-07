package com.demo.malfakeapi.specification;

import com.demo.malfakeapi.entity.MangaEntity;
import com.demo.malfakeapi.entity.MangaEntity_;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class MangaSpecification {

    public static Specification<MangaEntity> mangaScoreGreaterThan(Double score) {
        return ((manga, query, criteriaBuilder) -> criteriaBuilder.greaterThan(
                manga.get(MangaEntity_.SCORE), score));
    }

    public static Specification<MangaEntity> mangaScoreLessThan(Double score) {
        return ((manga, query, criteriaBuilder) -> criteriaBuilder.lessThan(
                manga.get(MangaEntity_.SCORE), score));
    }
}
