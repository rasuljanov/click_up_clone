package uz.pdp.clickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import uz.pdp.clickup.entity.WorkspaceUser;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkspaceUserRepository extends JpaRepository<WorkspaceUser, UUID> {

    Optional<WorkspaceUser> findByWorkspaceIdAndUserId(Long workspace_id, UUID user_id);

    @Transactional
    @Modifying
    void deleteByWorkspaceIdAndUserId(Long workspace_id, UUID user_id);

    List<WorkspaceUser> findAllByWorkspaceId(Long workspace_id);

    List<WorkspaceUser> findAllByUserId(UUID user_id);

    List<WorkspaceUser> findAllByWorkspaceIdAndWorkspaceRole_Name(Long workspace_id, String workspaceRole_name);
}
