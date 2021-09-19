package com.example.miwokapp;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    /** Image resource id of the word*/
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Audio resource id of the word*/
    private int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     *
     * @param audioResourceId is the audio resource id of the word
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     *
     * @param imageResourceId is the image of the word
     *
     * @param audioResourceId is the audio resource id of the word
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the default translation of the word
     */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * Get the miwok translation of the word
     */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /**
     * Get the image resource id of the word
     */
    public int getImageResourceId(){
        return mImageResourceId;
    }

    /**
     * Get the audio resource id of the word
     */
    public int getAudioResourceId(){
        return mAudioResourceId;
    }

    /**
     * Returns whether or not there is an image for
     * @return
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}