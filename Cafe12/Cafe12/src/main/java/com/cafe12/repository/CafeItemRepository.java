package com.cafe12.repository;

import com.cafe12.entity.CafeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeItemRepository extends JpaRepository<CafeItem,Long> {
}
