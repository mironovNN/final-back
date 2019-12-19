package ru.rosbank.javaschool.finalback.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosbank.javaschool.finalback.dto.PostResponseDto;
import ru.rosbank.javaschool.finalback.entity.UserEntity;
import ru.rosbank.javaschool.finalback.exception.AccessDeniedException;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PostService postService;

    public void isOperationAvailable(int postId, UserEntity entity) {
        PostResponseDto postDto = postService.getPostById(postId);
        if (postDto.getAuthorId() != entity.getId()) {
            throw new AccessDeniedException();
        }
    }

}