import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';

export default function FormDialog() {
    const [open, setOpen] = React.useState(false);
    const [url, setUrl] = React.useState("");
    const [name, setName] = React.useState("");

    const handleClickOpen = () => { setOpen(true); };
    const handleClose = () => { setOpen(false); };
    const handleChange = (event) => { 
        if (event.target.type === 'text' ) {
            setName(event.target.value);
        } else {
            setUrl(event.target.value);
        }
    };

    const handleSubmit = () => { 
        const body = {
            id: 42,
            name: name,
            giftCardURL: url
        }
        postData("http://localhost:8080/v1/business", body)
            .then(data => {
                console.log(data); // JSON data parsed by `data.json()` call
            });
        setOpen(false); 
    };

    async function postData(url = '', data = {}) {
        const response = await fetch(url, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });
        return response.json(); 
    }

    return (
        <div>
            <Button variant="outlined" color="primary" onClick={handleClickOpen}>Add Business</Button>
            <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Add Business</DialogTitle>
                <DialogContent>
                    <DialogContentText>Add a business</DialogContentText>
                    <TextField autoFocus fullWidth margin="dense" id="name" label="Business name" type="text" value={name} onChange={handleChange} />
                    <TextField autoFocus fullWidth margin="dense" id="url" label="Business URL" type="url" value={url} onChange={handleChange} />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose} color="primary">Cancel</Button>
                    <Button onClick={handleSubmit} color="primary">Subscribe</Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}