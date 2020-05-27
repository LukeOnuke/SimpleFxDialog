#basic info
$date = Get-Date -Format 'ddMMyyyy-HH-mm-ss-'
$folderName = $date + "SimpleFxDialog\"
$location = "C:\Users\lukak\Documents\NetBeansProjects\SimpleFxDialogDev\"
# SimpleFxDialog folder path
$sFD = "SimpleFxDialog\"
# SimpleFxDialogDev folder path
$sFDD = "SimpleFxDialogDev\"
#destination for the constructor
$destination = "F:\Projects\Publish\SimpleFxDialog\" + $folderName + $sFD

$delFile1 = "F:\Projects\Publish\SimpleFxDialog\" + "$folderName" + $sFD + "src\simplefxdialog\FXMLDocument.fxml"
$delFile2 = "F:\Projects\Publish\SimpleFxDialog\" + "$folderName" + $sFD + "src\simplefxdialog\FXMLDocumentController.java"
$delFile3 = "F:\Projects\Publish\SimpleFxDialog\" + "$folderName" + $sFD + "src\simplefxdialog\SimpleFxDialogDev.java"

echo "Copying to : " + $location
robocopy $location $destination /E /NODCOPY

echo "-------------------"
echo "Deleating dev files"
[Console]::Write("Process")
Remove-Item $delFile1
[Console]::Write(".")
Remove-Item $delFile2
[Console]::Write(".")
Remove-Item $delFile3
[Console]::Write(".done")
echo "Done deleating"
echo "-------------------"

Write-Host "Done copying release version library" -ForegroundColor White -BackgroundColor Green

echo "Copying to project"
# Copy the now setup file for compiling
$ddd = $destination + "src\"
robocopy $ddd "C:\Users\lukak\Documents\NetBeansProjects\SimpleFxDialog\src\" /is /it /E

Write-Host "Done setting up library" -ForegroundColor White -BackgroundColor Green
Write-Host "Now compile the SimpleFxDialog library and when its done press enter" -ForegroundColor White -BackgroundColor Red
pause

Write-Host "Now compile the SimpleFxDialog library and when its done press enter" -ForegroundColor Green

#now that its compiled copy it back to the library
robocopy "C:\Users\lukak\Documents\NetBeansProjects\SimpleFxDialog\" $destination /PURGE /is /it /E /NODCOPY

Write-Host "Done widh Library , now copying other files" -ForegroundColor White -BackgroundColor Green

#copy other projects
Write-Host "Copying dev" -ForegroundColor Green
$dist = "F:\Projects\Publish\SimpleFxDialog\" + $folderName + $sFDD
robocopy $location $dist /E /NODCOPY
Write-Host "Copying example" -ForegroundColor Green
$dist = "F:\Projects\Publish\SimpleFxDialog\" + $folderName + "Example\"
robocopy "C:\Users\lukak\Documents\NetBeansProjects\Example\" $dist /E /NODCOPY
Write-Host "Done other files" -ForegroundColor White -BackgroundColor Green

#place the binaries in a neat folder
Write-Host "Copying binaries" -ForegroundColor Green
$dist = "F:\Projects\Publish\SimpleFxDialog\" + $folderName + "Binaries"
robocopy "C:\Users\lukak\Documents\NetBeansProjects\SimpleFxDialog\dist\" $dist "SimpleFxDialog.jar"
robocopy "C:\Users\lukak\Documents\NetBeansProjects\Example\dist\" $dist "Example.jar"

Write-Host "Done" -ForegroundColor White -BackgroundColor Green
pause