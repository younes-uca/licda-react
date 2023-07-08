package ma.sir.vaccination.zynerator.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.sir.vaccination.zynerator.security.bean.Permission;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    public Permission findByName(String name);
}
