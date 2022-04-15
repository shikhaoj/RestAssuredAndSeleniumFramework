package com.qa.api.gorest.pojo;

public class LinksComplexJSON {
    private SelfComplexJson selfComplexJson;
    private EditComplexJson editComplexJson;
    private AvatarComplexJson avatarComplexJson;

    //constructor

    /**
     * This is the constructor for initializing all the key value pairs which has a parent
     * @param selfComplexJson
     * @param editComplexJson
     * @param avatarComplexJson
     */
    public LinksComplexJSON(SelfComplexJson selfComplexJson, EditComplexJson editComplexJson, AvatarComplexJson avatarComplexJson) {
        this.selfComplexJson = selfComplexJson;
        this.editComplexJson = editComplexJson;
        this.avatarComplexJson = avatarComplexJson;
    }

    //getter and setter methods

    public SelfComplexJson getSelf() {
        return selfComplexJson;
    }

    public void setSelf(SelfComplexJson selfComplexJson) {
        this.selfComplexJson = selfComplexJson;
    }

    public EditComplexJson getEdit() {
        return editComplexJson;
    }

    public void setEdit(EditComplexJson editComplexJson) {
        this.editComplexJson = editComplexJson;
    }

    public AvatarComplexJson getAvatar() {
        return avatarComplexJson;
    }

    public void setAvatar(AvatarComplexJson avatarComplexJson) {
        this.avatarComplexJson = avatarComplexJson;
    }

}
