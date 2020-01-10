package dai.android.plugin

import com.android.build.gradle.AppExtension
import dai.android.plugin.extension.DispatcherExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class MediaPlugin implements Plugin<Project> {

    public static final String DISPATCHER_EXTENSION_NAME = "dispatcher"

    private String rootDirPath
    private String packageName

    private static def getPackageName(variant) {
        if (null == variant) {
            return null
        }

        [variant.mergedFlavor.applicationId, variant.buildType.applicationIdSuffix].findAll().join()
    }


    @Override
    void apply(Project project) {

        println "<>: Plugin apply begin"

        rootDirPath = project.rootDir.absolutePath
        println "<>: root dir path: " + rootDirPath


        project.extensions.create(DISPATCHER_EXTENSION_NAME, DispatcherExtension)

        def android = project.extensions.getByType(AppExtension)

        // register Transform
        def classTransform = new MediaTransform(project)
        android.registerTransform(classTransform)


        project.afterEvaluate {
            android.applicationVariants.all { variant ->
                if (packageName == null) {
                    packageName = getPackageName(variant)
                    println "<>: package name: " + packageName
                }

                variant.outputs.each { output ->
                    println  output
                    //output.processManifestProvider.get().doLast {
                    //    println "<>: manifestOutputDirectory:" + output.processManifestProvider.get().manifestOutputDirectory.absolutePath
                    //}
                }
            }
        }

        println "<>: Plugin apply end"
    }
}
