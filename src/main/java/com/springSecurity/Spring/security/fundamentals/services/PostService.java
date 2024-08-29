package com.springSecurity.Spring.security.fundamentals.services;

import com.springSecurity.Spring.security.fundamentals.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createNewPost(PostDTO inputPost);

    PostDTO getPostById(Long postId);
}
