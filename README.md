# Extending VTEA with the SciJava framework
-----

This repository is a template for Scijava based plugin extension of volumetric tissue exploration and analysis.  This demonstration uses one of many annotations that VTEA will recognize when loading in FIJI-see link for more options[(Table 2)](https://www.biorxiv.org/content/10.1101/2021.12.27.474025v1.full.pdf).

```java
@Plugin(type = ImageProcessing.class)
public class ImageProcessingExample extends AbstractImageProcessing {}
```

