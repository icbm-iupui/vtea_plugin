# Extending VTEA with the SciJava framework
-----

This repository is a template for Scijava based plugin extension of volumetric tissue exploration and analysis.  This demonstration uses one of many annotations, type = ImageProcessing.class, that VTEA will recognize when loading in FIJI.

```java
@Plugin(type = ImageProcessing.class)
public class ImageProcessingExample extends AbstractImageProcessing {}
```

The additional annotations available are summarized in this table, or [here](https://www.biorxiv.org/content/10.1101/2021.12.27.474025v1.full.pdf):

|Functionality|Interface|Superclass|
|-------------|---------|----------|
|Image Processing|ImageProcessing|AbstractImageProcessing.class|
|Segmentation|Segmentation|AbstractSegmentation.class|
|Measured morphologies|Morphology|AbstractMorphology.class|
|Measurements to make on segmented objects|Measurment|AbstractMeasurment.class|
|Measurements to make on neighborhoods|NeighborhoodMeasurement|AbstractNeighborhoodMeasurement.class|
|Features derived from unsupervised analysis|Feature|AbstractFeature.class|
|Look up tables for plots|LUT|AbstractLUT.class|

