package com.locally.hypermobility.models;

import com.uber.h3core.util.LatLng;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CabLocation {

    private String cabId;
    private LatLng location;
}
