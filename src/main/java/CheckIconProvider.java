//import com.intellij.ide.IconProvider;
//import com.intellij.openapi.util.IconLoader;
//import com.intellij.psi.PsiElement;
//import com.intellij.psi.PsiFile;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//import javax.swing.*;
//
//public class CheckIconProvider extends IconProvider {
//
//    private static final String CHECK_ICON_URL = "/icons/checkIcon.png";
//
//    @Override
//    public @Nullable Icon getIcon(@NotNull PsiElement element, int flags) {
//        PsiFile containingFile = element.getContainingFile();
//        if (containingFile != null && containingFile.getName().endsWith(".xml")) {
//            return IconLoader.getIcon(CHECK_ICON_URL);
//        }
//        return null;
//    }
//}
