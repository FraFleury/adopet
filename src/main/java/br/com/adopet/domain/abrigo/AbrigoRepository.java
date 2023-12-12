package br.com.adopet.domain.abrigo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {

    Page<Abrigo> findAllByAtivoTrue(Pageable paginacao);
}
