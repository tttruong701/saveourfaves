import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';

// export default function FormDialog({isDialogOpen, setIsDialogOpen, businessName, businessURL, handleChange, handleSubmit}) {
export default function FormDialog(props) {
    const { isDialogOpen, setIsDialogOpen, businessName, businessURL, handleChange, handleSubmit } = props;

    const handleClickOpen = () => {
        setIsDialogOpen(true);
    };

    const handleClose = () => {
        setIsDialogOpen(false);
    };

    return (
        <div>
            <Button variant="outlined" color="primary" onClick={handleClickOpen}>Add Business</Button>
            <Dialog open={isDialogOpen} onClose={handleClose} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Add Business</DialogTitle>
                <DialogContent>
                    <DialogContentText>Add a business</DialogContentText>
                    <TextField autoFocus fullWidth margin="dense" id="name" label="Business name" type="text" value={businessName} onChange={handleChange} />
                    <TextField autoFocus fullWidth margin="dense" id="url" label="Business URL" type="url" value={businessURL} onChange={handleChange} />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose} color="primary">Cancel</Button>
                    <Button onClick={handleSubmit} color="primary">Subscribe</Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}