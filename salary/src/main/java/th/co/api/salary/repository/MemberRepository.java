package th.co.api.salary.repository;

import org.springframework.data.repository.CrudRepository;

import th.co.api.salary.model.MemberModel;

public interface MemberRepository extends CrudRepository<MemberModel, Integer>{

	Integer countByUsername(String username);

	Integer countByPhone(String phone);

	MemberModel findByUsername(String username);

}
