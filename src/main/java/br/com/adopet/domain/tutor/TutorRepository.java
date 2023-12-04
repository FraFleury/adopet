package br.com.adopet.domain.tutor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    UserDetails findByEmail(String email);

    boolean existsByEmail(String email);

    Page<Tutor> findAllByAtivoTrue(Pageable paginacao);
}
