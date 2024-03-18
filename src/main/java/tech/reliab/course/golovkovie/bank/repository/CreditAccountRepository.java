package tech.reliab.course.golovkovie.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.reliab.course.golovkovie.bank.model.entity.CreditAccount;

@Repository
public interface CreditAccountRepository extends JpaRepository<CreditAccount, Long> {

}
