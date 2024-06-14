package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions) {
        //add an image to the blog
        // no need of exception handling for this assignment
        Blog blog=blogRepository2.findById(blogId).get();

        //if you here means blog exist

        Image image = new Image(); //create the image
        //set image attributes
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);

        //add current image to the blog(parent)
        blog.getImageList().add(image);

        //saving blog(parent) ,image(child) will be autosaved
        blogRepository2.save(blog);

        return image;
    }

    public void deleteImage(Integer id)  {
        //find the image
        // no need to check for exception handling for this assignment

        imageRepository2.deleteById(id);

        //image exist so delete it

    }

    public int countImagesInScreen(Integer id, String screenDimensions)  {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        // find the index of 'X'
        int indOfX=screenDimensions.indexOf('X');
        // find the left(length & right(breadth) character around 'X' and convert this into integer
        int screenH=Integer.parseInt(screenDimensions.substring(0,indOfX));
        int screenW=Integer.parseInt(screenDimensions.substring(indOfX+1));

        //find the image that is to be set in the given dimension(screenDimensions)
        Image image=imageRepository2.findById(id).get();

        //image is found , extract its wdith and height
        int indxOfXinImage=image.getDimensions().indexOf('X');

        int imageH=Integer.parseInt(image.getDimensions().substring(0,indxOfXinImage));
        int imageW=Integer.parseInt(image.getDimensions().substring(indxOfXinImage+1));

        return (screenH/imageH) * (screenW/imageW); //num of complete images that fit in the screen of given dimensions
    }
}
