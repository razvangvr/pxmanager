
function DWRAction() { }
DWRAction._path = '/mag4media/dwr';

DWRAction.execute = function(p0, p1, callback) {
    DWREngine._execute(DWRAction._path, 'DWRAction', 'execute', p0, p1, false, false, false, callback);
}
