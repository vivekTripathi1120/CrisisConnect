package com.crisisConnect.CrisisConnect.masterService.utils;

public final class UserConstants {

    public static final String USER_UPDATE_MSG = "User Updated Successfully!";
    public static final Integer USER_PHONE_TYPE = 1;
    public static final Integer USER_EMERGENCY_PHONE_TYPE = 2;
    public static final Integer USER_TYPE = 1;
    public static final Integer EMERGENCY_AUTHROITY_TYPE = 2;
    public static final Long HOSPITAL_TYPE = 1L;
    public static final Long SHELTER_TYPE = 2L;
    public static final Long FIRE_STATION_TYPE = 3L;
    public static final Long POLICE_STATION_TYPE = 4L;

    private void AppConstants() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static final Integer CitizenUniqIdLength = 12;
}
