package com.mailserver.service;

import com.mailserver.model.Folder;
import org.springframework.stereotype.Service;

@Service
public class FolderService {
    private UserService userService = UserService.getInstance();
    public void createFolder(String email,String folderName){
        userService.getUserByEmail(email).getFolders().add(new Folder(folderName));
    }
    public void deleteFolder(String email,String folderName){
        userService.getUserByEmail(email).getFolders().removeIf(folder -> folder.getName().equalsIgnoreCase(folderName));
    }
    public Folder getFolder(String email,String folderName){
        return userService.getUserByEmail(email).getFolders().stream().filter(folder -> folder.getName().equalsIgnoreCase(folderName)).findFirst().orElse(null);
    }
}