package ui;

import com.intellij.ide.IconProvider;
import com.intellij.lang.Language;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;

public class CheckIconProvider extends IconProvider {
    public String CHECK_ICON_URL = "/icons/checkIcon.png";

    private final Icon icon;
    public CheckIconProvider()
    {
        this.icon = IconLoader.getIcon( "/icons/checkIcon.png" );
    }

    @Override
    public @Nullable Icon getIcon(@NotNull PsiElement element, int flags) {
        PsiFile containingFile = element.getContainingFile();
//        String name = containingFile.getName();

        if (containingFile != null && element.isWritable()) {
            return IconLoader.getIcon(CHECK_ICON_URL);
        }
        return null;
    }


//    public Icon getCheckIcon( VirtualFile element) {
////        PsiFile containingFile = element.getContainingFile();
////        String name = containingFile.getName();
//
//        if (element != null) {
//            return IconLoader.getIcon(CHECK_ICON_URL);
//        }
//        return null;
//    }


//    @Override
//    public Icon getIcon( @NotNull PsiElement psiElement, int i )
//    {
//        Language language = psiElement.getLanguage();
//        String languageDisplayName = language.getDisplayName();
//        if( !languageDisplayName.equals( "java" ) )
//        {
//            return null;
//        }
//        if( psiElement.getText().contains( "<somespecifcxmlstringthatdefinesyourcustomxml" ) )
//        {
//            return icon;
//        }
//        else
//        {
//            return null;
//        }
//    }
}
