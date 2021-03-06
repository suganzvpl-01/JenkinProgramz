#include <MsgBoxConstants.au3>
#include <SQLite.au3>
#include <SQLite.dll.au3>

Local $hFile, $vData, $sFileName, $sData, $hQuery, $aRow, $sMsg
_SQLite_Startup()
ConsoleWrite("_SQLite_LibVersion=" & _SQLite_LibVersion() & @CRLF)
_SQLite_Open()
_SQLite_Exec(-1, "CREATE TABLE IF NOT EXISTS Test (data blob);")
$vData = Binary("Hello" & Chr(0) & "World"); = 48656C6C6F00576F726C64
$sData = _SQLite_Encode($vData)
_SQLite_Exec(-1, "INSERT INTO Test VALUES (" & $sData & ");")
$vData = Binary(Chr(0) & @CRLF); = 000D0A
$sData = _SQLite_Encode($vData)
_SQLite_Exec(-1, "INSERT INTO Test VALUES (" & $sData & ");")
$vData = Binary(Chr(0)); = 00 but this is interpreted as Number and returns 0000000000000000
$sData = _SQLite_Encode($vData)
_SQLite_Exec(-1, "INSERT INTO Test VALUES ( " & $sData & " );")
_SQLite_Query(-1, "SELECT * FROM Test;", $hQuery)
While _SQLite_FetchData($hQuery, $aRow, 1) = $SQLITE_OK
	$sMsg &= Hex($aRow[0]) & @CRLF
WEnd
MsgBox($MB_SYSTEMMODAL, "Result", $sMsg)
_SQLite_Close()
_SQLite_Shutdown()
