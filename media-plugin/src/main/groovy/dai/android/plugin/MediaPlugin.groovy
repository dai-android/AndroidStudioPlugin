package dai.android.plugin

import com.android.build.gradle.AppExtension
import dai.android.plugin.extension.DispatcherExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class MediaPlugin implements Plugin<Project> {

    public static final String DISPATCHER_EXTENSION_NAME = "dispatcher"

    @Override
    void apply(Project project) {

        println "<>: Plugin apply begin"

        project.extensions.create(DISPATCHER_EXTENSION_NAME, DispatcherExtension)

        def android = project.extensions.getByType(AppExtension)

        // register Transform
        def classTransform = new MediaTransform(project)
        android.registerTransform(classTransform)

        println "<>: Plugin apply end"
    }
}
